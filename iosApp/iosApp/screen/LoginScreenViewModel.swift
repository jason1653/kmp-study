//
//  LoginScreenViewModel.swift
//  iosApp
//
//  Created by jason on 4/22/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import shared


extension LoginScreen {
    struct LoginFormState {
        let emailError: String?
        let pwdError: String?
    }
    class ViewModel: ObservableObject {
        @Published var formState = LoginFormState(emailError: nil, pwdError: nil)
        let loginValidator: LoginValidator
        
        init() {
            self.loginValidator = LoginValidator()
        }
        
        
        func loginDataChanged(email: String, pwd: String) {
            formState = LoginFormState(
                emailError: (loginValidator.emailValidator(email: email) as? ValidationResult.Failure)?.message, 
                pwdError: (loginValidator.passwdValidator(passwd: pwd) as? ValidationResult.Failure)?.message)
        }
        
    }
}
