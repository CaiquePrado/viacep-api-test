package response;

import dto.ErrorMessage;

public interface ErrorMessageResponse {

    static ErrorMessage badRequestErrorMessage(){
        return ErrorMessage
        .builder()
        .title("Verifique a URL")
        .status("Http 400")
        .details("{Bad Request}")
        .build();
    }
}
