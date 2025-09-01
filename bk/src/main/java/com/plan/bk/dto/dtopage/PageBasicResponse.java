    package com.plan.bk.dto.dtopage;

    import lombok.Builder;
    import lombok.Getter;
    import lombok.Setter;
    import org.springframework.data.domain.Page;

    import java.util.List;
    @Getter
    @Setter
    @Builder
    public class PageBasicResponse<T> {

        List<T> content;
        int totalPages;
        Long totalElements;
        int pageSize;
        int currentPage;

        public static <T> PageBasicResponse<T> from(Page<T> page){

            return  PageBasicResponse.<T>builder()
                    .content(page.getContent())
                    .totalPages(page.getTotalPages())
                    .totalElements(page.getTotalElements())
                    .pageSize(page.getSize())
                    .currentPage(page.getNumber())
                    .build();
        }

    }
