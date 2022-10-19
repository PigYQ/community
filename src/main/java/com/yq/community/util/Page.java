package com.yq.community.util;

public class Page {
    //当前页码
    private int currentPage = 1;
    //页面大小
    private int pageSize = 2;
    //总行数
    private int totalRows;
    //访问路径
    private String path;

    /**
     * 获取总页数
     */
    public int getPageNums(){
        if (totalRows%pageSize == 0)
            return totalRows/pageSize;
        else
            return totalRows/pageSize+1;
    }

    /**
     * 获取起始行数
     */
    public int getPageNo(){
        return (currentPage-1)*pageSize;
    }

    /**
     * 获取起始页码值
     */
    public int getFromPage(){
        int fromPage = currentPage-2;
        return Math.max(fromPage, 1);
    }

    /**
     * 获取结束页码
     */
    public int getEndPage(){
        int endPage = currentPage+2;
        int pageNums = getPageNums();
        return Math.min(endPage, pageNums);
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        if (currentPage >= 1){
            this.currentPage = currentPage;
        }
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if (pageSize >= 1 && pageSize <=100){
            this.pageSize = pageSize;
        }
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        if (totalRows >= 0){
            this.totalRows = totalRows;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
