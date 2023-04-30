/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sebastianContreras.Curriculumbackend.auth;

import com.sebastianContreras.Curriculumbackend.Model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author root
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class AuthenticationResponse {

    private String token;
    private User user;
}
