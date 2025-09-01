export interface PageBasicResponse<T> {
  content: T[];
  totalPages: number;
  totalElements: number;
  pageSize: number;
  currentPage: number;
}
