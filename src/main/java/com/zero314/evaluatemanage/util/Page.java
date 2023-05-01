package com.zero314.evaluatemanage.util;

import lombok.*;

import java.util.List;

/**
 * @author yh
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Page<T> {
    /**
     * 总记录数
     */
    private Long total;
    /**
     * 总页数
     */
    private Long totalPage;
    /**
     * 当前页数
     */
    private Long currentPage;
    /**
     * 分页大小
     */
    private Long pageSize;
    /**
     * 分页记录
     */
    private List<T> list;

    public Page(Long currentPage, Long pageSize, Long total, List<T> list) {
        this.total = total;
        this.totalPage = (long) Math.ceil((double) total / pageSize);
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.list = list;
    }
}
