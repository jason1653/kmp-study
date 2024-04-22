//
//  LoginScreen.swift
//  iosApp
//
//  Created by jason on 4/19/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct LoginScreen: View {
    @Binding var isShowLoginScreen: Bool
    @State private var email: String = ""
    @State private var password: String = ""
    
    @ObservedObject var loginViewModel: LoginScreen.ViewModel = LoginScreen.ViewModel()
    
    var body: some View {
        VStack(alignment: .leading, content: {
            HStack {
                Button(action: {
                    isShowLoginScreen = false
                }) {
                    HStack {
                        Image(systemName: "xmark")
                            .resizable()
                            .scaledToFit()
                            .frame(width: 15, height: 15)
                            .foregroundColor(.black)
                    }
                                    
                }
                .padding(.top, 20)
                Spacer()
            }
            
            
            Text("로그인")
                .padding(.top, 30)
                .fontWeight(.bold)
                .font(.system(size: 24))
                
            
            DefaultTextField(label: "Email", titleKey: "email", secured: false, errorMessage: loginViewModel.formState.emailError, onChange: {
                loginViewModel.loginDataChanged(email: email, pwd: password)
            }, text: $email)
                .padding(.top, 50)
            
            DefaultTextField(label: "Password", titleKey: "password", secured: true, errorMessage: loginViewModel.formState.pwdError, onChange: {
                loginViewModel.loginDataChanged(email: email, pwd: password)
            }, text: $password)
                .padding(.top, 20)

            
            Spacer()
            Button(action: {
            }) {
                Text("로그인")
                    .frame(maxWidth: .infinity)
                    .padding()
                    .background(Color.blue)
                    .foregroundColor(Color.white)
                    .fontWeight(.bold)
                    .font(.system(size: 16))
                    .cornerRadius(5.0)
            }
        })
        .padding(EdgeInsets(top: 0, leading: 20, bottom: 20, trailing: 30))
        
    }
}


struct LoginScreen_Previews: PreviewProvider {
    @State static var isShowLoginScreen: Bool = false
    
    static var previews: some View {
        LoginScreen(isShowLoginScreen: $isShowLoginScreen)
    }
}


