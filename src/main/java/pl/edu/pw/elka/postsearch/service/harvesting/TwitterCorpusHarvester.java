package pl.edu.pw.elka.postsearch.service.harvesting;

import org.apache.commons.lang.StringEscapeUtils;
import org.elasticsearch.common.joda.time.format.DateTimeFormatter;
import pl.edu.pw.elka.postsearch.commons.exceptions.InvalidPostException;
import pl.edu.pw.elka.postsearch.commons.validator.Validator;
import pl.edu.pw.elka.postsearch.model.Post;
import pl.edu.pw.elka.postsearch.model.Posts;
import pl.edu.pw.elka.postsearch.model.User;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Klasa wczytująca korpus tekstowy - posty twitter'a zgodne
 * z formatem zaprezentowanym w
 * <a href="http://an.kaist.ac.kr/traces/WWW2010.html">kaist</a>.
 * <pre>
 *   [Data utworzenia postu: yyyyMMdd]\t[id postu: \d+]\t[nazwa użytkownika: a-zA-Z0-9+]\t
 *   [treść posta: .*]\t[followers]\t
 *   [dwuliterowy kod kraju]\t[źródło pochodzenia postu]\t[link do awatara użytkownika]\t
 *   [data utworzenia postu]\t[id postu]\n
 *  </pre>
 * gdzie:
 * \t = 0x09,
 * \n = 0x0a
 * <br/>
 * Treść jednego postu wejściowego jest zawsze wyescapeowana.
 * <br/>
 * Na wyjściu otrzymujemy niewyescapeowany post.
 */
public class TwitterCorpusHarvester implements Harvester<Posts> {
    public static final SimpleDateFormat CREATION_DATE_SDF = new SimpleDateFormat("yyyyMMdd");
    private final Integer pageSize;
    private BufferedReader bufferedReader;
    private String lastPost = null;

    public TwitterCorpusHarvester(final Reader reader, final Integer pageSize) {
        this.pageSize = pageSize;
        this.bufferedReader = new BufferedReader(reader);
    }

    public TwitterCorpusHarvester(final File file, final Integer pageSize) throws FileNotFoundException {
        this(new FileReader(file), pageSize);
    }

    public TwitterCorpusHarvester(final String filename, final Integer pageSize) throws FileNotFoundException {
        this(new File(filename), pageSize);
    }

    @Override
    public Iterator<Posts> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        if (lastPost == null) {
            lastPost = readLine();
        }
        return lastPost != null;
    }

    @Override
    public Posts next() throws InvalidPostException {
        List<String> posts = new LinkedList<String>();
        int i = 0;

        if (lastPost != null) {
            posts.add(lastPost);
            lastPost = null;
            i++;
        }

        for (; i < pageSize; ++i) {
            String post = readLine();
            posts.add(post);
        }
        return readPosts(posts);
    }

    @Override
    public void remove() {/** Empty by design */}

    private Posts readPosts(final List<String> postsData) throws InvalidPostException {
        Posts posts = new Posts();
        for (final String post : postsData) {
            posts.add(readPost(post));
        }
        return posts;
    }

    private Post readPost(final String postData) throws InvalidPostException {
        final String postDataAfterDecoding = StringEscapeUtils.unescapeHtml(postData);
        final String[] parts = postDataAfterDecoding.split("\t");
        Validator.assertTrue(parts.length == 11,
                "There should be exactly 11 parts of harvested post.");
        Post post;
        try {
            post = new Post(readCreationDate(parts[0]),
                    Long.parseLong(parts[1]),
                    new User(parts[2], new URL(parts[8])),
                    parts[3],
                    parts[6]);
        } catch (ParseException | MalformedURLException | NumberFormatException e) {
            throw new InvalidPostException(e.getMessage());
        }
        return post;
    }

    private Date readCreationDate(String dateString) throws ParseException {
        return CREATION_DATE_SDF.parse(dateString);
    }

    private String readLine() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            throw new IllegalAccessError(e.getMessage());
        }
    }

}
