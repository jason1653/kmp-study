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
    
    
    func loginProcess() {
        
        memberService.adminUserList(){ result, error in
            print("데이터 가져오기")
            print(result?.body?.total)
            print(result?.body?.totalPage)
            print(result?.body?.users)
            print(error)
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
