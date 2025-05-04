package com.yesjm.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PaginatedResponseDto<T> {

    private boolean success;
    private PaginatedData<T> data;
    private String message;

    public PaginatedResponseDto(boolean success, PaginatedData<T> data) {
        this.success = success;
        this.data = data;
        this.message = "요청이 성공적으로 처리되었습니다.";
    }

    @Getter
    @Setter
    public static class PaginatedData<T> {

        private List<T> items;
        private Pagination pagination;

        public PaginatedData(List<T> items, Pagination pagination) {
            this.items = items;
            this.pagination = pagination;
        }

    }

    @Getter
    @Setter
    public static class Pagination {

        private int totalItems;
        private int totalPages;
        private int currentPage;
        private int perPage;

        public Pagination(int totalItems, int totalPages, int currentPage, int perPage) {
            this.totalItems = totalItems;
            this.totalPages = totalPages;
            this.currentPage = currentPage;
            this.perPage = perPage;
        }

    }

}
