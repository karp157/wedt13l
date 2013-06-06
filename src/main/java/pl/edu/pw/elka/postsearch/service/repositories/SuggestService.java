package pl.edu.pw.elka.postsearch.service.repositories;

import org.elasticsearch.action.suggest.SuggestRequestBuilder;
import org.elasticsearch.action.suggest.SuggestResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.search.suggest.Suggest;
import org.elasticsearch.search.suggest.SuggestBuilder;
import org.elasticsearch.search.suggest.term.TermSuggestionBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.pw.elka.postsearch.commons.validator.Validator;

import java.util.List;

public class SuggestService {
    private static final Float MIN_SCORE = 0.5f;

    private Client client;

    public SuggestService(final Client client) {
        this.client = client;
    }

    public String getMostLikelySuggestions(String suggestText) {
        Validator.assertNotNull(suggestText, "Null suggest text");
        Validator.assertNotEmpty(suggestText, "Empty suggest text");
        final SuggestRequestBuilder builder = client.prepareSuggest("twitter");

        TermSuggestionBuilder termSuggestBuilder = SuggestBuilder
                                    .termSuggestion("phrase-suggestion")
                                    .text(suggestText)
                                    .field("rawMessage");

        builder.addSuggestion(termSuggestBuilder);
        builder.setSuggestText(suggestText);

        StringBuilder stringBuilder = new StringBuilder();

        SuggestResponse actionGet = builder.execute().actionGet();
        Suggest suggest = actionGet.getSuggest();

        boolean isSomeSuggestion = false;
        for(Suggest.Suggestion suggestion : suggest) {
            List entries = suggestion.getEntries();
            for(Object entry : entries) {
                Suggest.Suggestion.Entry suggestionEntry = (Suggest.Suggestion.Entry) entry;
                String part = suggestionEntry.getText().string();
                float maxScore = 0f;
                for(Object object : suggestionEntry.getOptions()) {
                    Suggest.Suggestion.Entry.Option option = (Suggest.Suggestion.Entry.Option) object;
                    if(option.getScore() > maxScore) {
                        part = option.getText().string();
                        isSomeSuggestion = true;
                        maxScore = option.getScore();
                    }
                }
                stringBuilder.append(part).append(" ");
            }
        }
        return isSomeSuggestion ? stringBuilder.toString() : null;
    }

}
