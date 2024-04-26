//
//  RegistScreen.swift
//  iosApp
//
//  Created by jason on 4/26/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct RegistScreen: View {
    @State var userName: String = ""
    @State var userNameErrorMessage: String = ""
    var body: some View {
        ZStack {
            VStack(alignment: .leading) {
                TopNavigation(action: {
                }, iconName: .close)
                
                H1Text(text: "회원가입")
                
                DefaultTextField(label: "Email", titleKey: "이메일을 입력해주세요", secured: false, errorMessage: $userNameErrorMessage, onChange: {
                }, text: $userName)
                .padding(.top, 50)
                .padding(.bottom, 30)
            }
        }
    }
}

#Preview {
    RegistScreen()
}
