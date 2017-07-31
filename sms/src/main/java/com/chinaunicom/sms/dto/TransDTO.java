package com.chinaunicom.sms.dto;

import com.chinaunicom.sms.util.PageUtil;

import java.util.List;

public class TransDTO<T> {

    List<T> list;

    PageUtil page;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public PageUtil getPage() {
        return page;
    }

    public void setPage(PageUtil page) {
        this.page = page;
    }


}
