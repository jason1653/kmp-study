//
//  RegistScreen.swift
//  iosApp
//
//  Created by jason on 4/26/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct RegistScreen: View {
    @Binding var isShowRegistScreen: Bool
    @State var userName: String = ""
    @State var userNameErrorMessage: String = ""
    var body: some View {
        ModalLayout {
            TopNavigation(action: {
                isShowRegistScreen = false
            }, iconName: .close)
            
            
            ScrollView {
                
                VStack(alignment: .leading) {
                    H1Text(text: "회원가입")
                    
                    
                    DefaultTextField(label: "아이디", titleKey: "아이디를 입력해주세요", secured: false, errorMessage: $userNameErrorMessage, onChange: {
                    }, text: $userName)
                    .padding(.top, 30)
                    
                    
                    
                    
                    DefaultTextField(label: "패스워드", titleKey: "패스워드를 입력해주세요", secured: true, errorMessage: $userNameErrorMessage, onChange: {
                    }, text: $userName)
                    .padding(.top, 20)
                    
                    DefaultTextField(label: "패스워드 확인", titleKey: "패스워드를 입력해주세요", secured: true, errorMessage: $userNameErrorMessage, onChange: {
                    }, text: $userName)
                    .padding(.top, 20)
                    
                    
                    DefaultTextField(label: "Email", titleKey: "이메일을 입력해주세요", secured: false, errorMessage: $userNameErrorMessage, onChange: {
                    }, text: $userName)
                    .padding(.top, 20)
                    
                    DefaultTextField(label: "이름", titleKey: "이름을 입력해주세요", secured: false, errorMessage: $userNameErrorMessage, onChange: {
                    }, text: $userName)
                    .padding(.top, 20)
                    
                    
                    DefaultTextField(label: "닉네임", titleKey: "닉네임을 입력해주세요", secured: false, errorMessage: $userNameErrorMessage, onChange: {
                    }, text: $userName)
                    .padding(.top, 20)
                }
            }
            

            PrimaryButton(title: "회원가입", action: {})
                .padding(.top, 20)

        }
    }
}



struct RegistScreen_Previews: PreviewProvider {
    @State static var isShowRegistScreen: Bool = false
    
    static var previews: some View {
        RegistScreen(isShowRegistScreen: $isShowRegistScreen)
    }
}



