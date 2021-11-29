package com.komputerkit.ukomde_afa;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginRegInterfaace {

    @POST("/api/login")
    Call<GetLogin> loginReg(@Body Login login);

    @POST("api/register")
    Call<GetRegister> register(@Body RegisterModel registerModel);


}
