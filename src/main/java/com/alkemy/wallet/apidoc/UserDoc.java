package com.alkemy.wallet.apidoc;

import com.alkemy.wallet.model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserDoc {

    @Operation(
            summary = "Fetch all users",
            description = "Fetches all users entities and their data from data source")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    content = @Content,
                    description = "Users found"
            ),
            @ApiResponse(
                    responseCode = "204",
                    content = @Content,
                    description = "No content"
            ),
    })
    ResponseEntity<List<User>> get();


    @Operation(
            summary = "Deletes a user by id",
            description = "Deletes a user by id from data source. It is a logical delete)")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    content = @Content,
                    description = "User deleted"
            ),
            @ApiResponse(
                    responseCode = "404",
                    content = @Content,
                    description = "User not found"
            ),
    })
    ResponseEntity<Void> delete(Long id);

}
