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
    
    func createUserProcess() async {
        let createUserRequest = CreateUserRequest(
            userName: "테스트23",
            phoneNumber: "010-7442-2662",
            gender: "M",
            birthDate: "19810627",
            userId: "saga165181111",
            nickName: "테스트2727272",
            userPwd: "Test!$2233",
            userPwdConfirm: "Test!$2233",
            email: "saga1654@naver.com"
        )
        
        ErrorHandler.handle({
            try await self.memberService.createUser(body: createUserRequest)
        }) { response, error in
            
            if let error = error as? APIErrorResponse {
                print("API 에러")
                print(error.code)
                print(error.message)
            } else if let error = error {
                print("오류 발생")
            }
            
        }
        
        
    }
    
    
    func loginProcess() async {
        isLoading = true

        do {
            let exists = try await memberService.existsUserId(userId: "test")
            print(exists)
            print("성공")
        } catch let error as NSError {
            print("오류 - catch")
            print(error)
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
