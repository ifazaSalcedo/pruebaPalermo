import { HttpClient } from "@angular/common/http";
import { catchError, Observable, throwError } from "rxjs";
import { ErrorApiHandlerService } from "../../../../core/error/api/api_error.service";
import { Injectable } from "@angular/core";

@Injectable({
  providedIn: 'root'
})

export class ProductoApiService {

  uri = 'http://localhost:8080/api/v1/productos';


  constructor(private http: HttpClient, private errorApi: ErrorApiHandlerService) { }




  getListProductosListaPrecios() :  Observable<any>{
    return this.http.get<any>(`${this.uri}/listado-productos`)
    .pipe(
      catchError(error => throwError(() => this.errorApi.handleError(error)))
    );
  }

}
