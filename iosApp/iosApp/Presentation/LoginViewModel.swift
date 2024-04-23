//
//  LoginViewModel.swift
//  iosApp
//
//  Created by jason on 4/23/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import shared

class LoginViewModel: ObservableObject {
    @Published var email: String = ""
    @Published var passwd: String = ""
    
    @Published var emailMessage: String = ""
    @Published var passwdMessage: String = ""
    @Published var isValid: Bool = false
    
    private let loginValidator = LoginValidator()
    
    func emailValidator() {
        isValid = false
        let validator = loginValidator.emailValidator(email: email)
        emailMessage = validator.message
        isValid = true
    }
    
    
    func passwdValidator() {
        isValid = false
        let validator = loginValidator.passwdValidator(passwd: passwd)
        passwdMessage = validator.message
        isValid = true
    }
    
    
    func loginProcess() {

        emailValidator()
        passwdValidator()
        
        if(isValid) {
            print("validation 오류")
            return
        }
        
        print("로그인")
        
    }
}
