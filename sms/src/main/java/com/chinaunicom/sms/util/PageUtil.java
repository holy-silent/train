package com.chinaunicom.sms.util;

public class PageUtil {

    //当前页面编码
    private Integer pageNumber = 1;

    //页面记录条数
    private Integer pageSize = Util.PAGE_SIZE;

    //第几条记录开始
    private Integer startNumber = 0;

    //记录总条数
    private Integer recordNumber;

    //页码序列首
    private int startPage;

    //页码序列尾
    private int endPage;

    //页面总数
    private Integer totlePageNumber;

    //是否有前一页
    private boolean hasPreviousPage;

    //是否有后一页
    private boolean hasAfterPage;

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getRecordNumber() {
        return recordNumber;
    }

    public void setRecordNumber(Integer recordNumber) {
        this.recordNumber = recordNumber;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public Integer getTotlePageNumber() {
        return totlePageNumber;
    }

    public void setTotlePageNumber(Integer totlePageNumber) {
        this.totlePageNumber = totlePageNumber;
    }

    public boolean isHasPreviousPage() {
        return hasPreviousPage;
    }

    public void setHasPreviousPage(boolean hasPreviousPage) {
        this.hasPreviousPage = hasPreviousPage;
    }

    public boolean isHasAfterPage() {
        return hasAfterPage;
    }

    public void setHasAfterPage(boolean hasAfterPage) {
        this.hasAfterPage = hasAfterPage;
    }

    public Integer getStartNumber() {
        return startNumber;
    }

    public void setStartNumber(Integer startNumber) {
        this.startNumber = startNumber;
    }

    public PageUtil(Integer pageNumber, Integer pageSize, Integer recordNumber) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.recordNumber = recordNumber;
        this.startNumber = (pageNumber - 1) * pageSize;
        this.totlePageNumber = recordNumber / pageSize;
        if(recordNumber % pageSize != 0) {
            totlePageNumber++;
        }
        this.cauculatePageView();
        this.hasPreviousPage = pageNumber == 1 ? false : true;
        this.hasAfterPage = pageNumber == totlePageNumber ? false : true;
    }

    private void cauculatePageView(){
        if (this.totlePageNumber <= 5) {
            this.startPage = 1;
            this.endPage = this.totlePageNumber;
        } else if (this.pageNumber <= 3) {
            this.startPage = 1;
            this.endPage = 5;
        } else if (this.totlePageNumber - this.pageNumber < 3) {
            this.startPage = this.totlePageNumber - 4;
            this.endPage = this.totlePageNumber;
        } else {
            this.startPage = this.pageNumber - 2;
            this.endPage = this.pageNumber + 2;
        }
    }

    @Override
    public String toString() {
        return "PageUtil{" +
                "pageNumber=" + pageNumber +
                ", pageSize=" + pageSize +
                ", startNumber=" + startNumber +
                ", recordNumber=" + recordNumber +
                ", startPage=" + startPage +
                ", endPage=" + endPage +
                ", totlePageNumber=" + totlePageNumber +
                ", hasPreviousPage=" + hasPreviousPage +
                ", hasAfterPage=" + hasAfterPage +
                '}';
    }
}

