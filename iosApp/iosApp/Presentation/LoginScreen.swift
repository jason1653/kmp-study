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
    
    @ObservedObject var viewModel: LoginViewModel = LoginViewModel()
    
    
    
    var body: some View {
        ModalLayout {
            TopNavigation(action: {
                isShowLoginScreen = false
            }, iconName: .close)
            
            H1Text(text: "로그인")
            
            
            DefaultTextField(label: "Email", titleKey: "이메일을 입력해주세요", secured: false, errorMessage: $viewModel.emailMessage, onChange: {
                viewModel.emailValidator()
            }, text: $viewModel.email)
            .padding(.top, 50)
            .padding(.bottom, 30)
            
            DefaultTextField(label: "Password", titleKey: "패스워드를 입력해주세요", secured: true, errorMessage: $viewModel.passwdMessage, onChange: {
                viewModel.passwdValidator()
            }, text: $viewModel.passwd)
            
            Spacer()
            Button(action: {
                Task {
//                        await viewModel.loginProcess()
                    await viewModel.createUserProcess()
                }
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
        }
        
        if viewModel.isLoading {
            LoadingView()
        }
        
    }
}





struct LoginScreen_Previews: PreviewProvider {
    @State static var isShowLoginScreen: Bool = false
    
    static var previews: some View {
        LoginScreen(isShowLoginScreen: $isShowLoginScreen)
    }
}


