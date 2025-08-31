export interface PageBasicResponse<T> {
  content: T[];
  totalPages: number;
  totalElements: number;
  pagiSize: number;
  currentPage: number;
}
