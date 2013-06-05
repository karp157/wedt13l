package pl.edu.pw.elka.postsearch.controller.beans;

import org.springframework.web.multipart.MultipartFile;

public class FileUpload {
    private MultipartFile multipartFile;
    private Integer pageSize;
    private String countryCode;

    public FileUpload() {
    }

    public FileUpload(final MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(final MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(final Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(final String countryCode) {
        this.countryCode = countryCode;
    }
}
