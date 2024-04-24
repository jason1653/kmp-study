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
        ZStack {
            
            
            VStack(alignment: .leading) {
                HStack {
                    Button(action: {
                        isShowLoginScreen = false
                    }) {
                        Image(systemName: "xmark")
                            .resizable()
                            .scaledToFit()
                            .frame(width: 15, height: 15)
                            .foregroundColor(.black)
                    }
                    .padding(.top, 20)
                    Spacer()
                }
                
                Text("로그인")
                    .fontWeight(.bold)
                    .font(.system(size: 24))
                    .padding(.top, 30)
                
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
                        await viewModel.loginProcess()
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
            .padding(EdgeInsets(top: 0, leading: 20, bottom: 20, trailing: 20))
            
            if viewModel.isLoading {
                LoadingView()
            }
        }
    }
}





struct LoginScreen_Previews: PreviewProvider {
    @State static var isShowLoginScreen: Bool = false
    
    static var previews: some View {
        LoginScreen(isShowLoginScreen: $isShowLoginScreen)
    }
}


