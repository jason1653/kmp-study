//
//  LoginViewModel.swift
//  iosApp
//
//  Created by jason on 4/23/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import shared

@MainActor
class LoginViewModel: ObservableObject {
    @Published var email: String = ""
    @Published var passwd: String = ""
    
    @Published var emailMessage: String = ""
    @Published var passwdMessage: String = ""
    @Published var isValid: Bool = false
    @Published var isLoading: Bool = false
    
    
    private let loginValidator = LoginValidator()
    private let memberService = MemberService()
    
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
    
    
    func loginProcess() async {
        isLoading = true

        do {
            let exists = try await memberService.existsUserId(userId: "")
            print("성공")
        } catch let error as NSError {
            print("오류 - catch")
            print(error.localizedDescription)
        }


        emailValidator()
        passwdValidator()
        
        if(isValid) {
            print("validation 오류")
            return
        }
        
        print("로그인")
        
    }
}
