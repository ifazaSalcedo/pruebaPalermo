import { Injectable } from "@angular/core";
import { ApiMessageError } from "./api_error.model";

@Injectable({ providedIn: 'root' })

export class ErrorApiHandlerService {

  handleError(error: any): ApiMessageError {
    const apiError: ApiMessageError = {
      code: error.code || 'UNKNOWN_ERROR',
      message: error.message || 'An unknown error occurred'
    };
    // Aquí puedes agregar lógica adicional, como registrar el error en un servicio de logging
    console.error('API Error:', apiError);
    return apiError;
  }


}
