//
//  LoginScreen.swift
//  iosApp
//
//  Created by jason on 4/19/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct LoginScreen: View {
    @State private var email: String = ""
    @State private var password: String = ""
    var body: some View {
        VStack(alignment: .leading, content: {
            HStack {
                Button(action: {}) {
                    HStack {
                        Image(systemName: "chevron.left")
                    }
                                    
                }
                .padding(.top, 20)
                Spacer()
            }
            
            
            Text("로그인")
                .padding(.top, 20)
                .fontWeight(.bold)
                .font(.system(size: 24))
                
            
            DefaultTextField(label: "Email", titleKey: "email", secured: false, onChange: {}, text: $email)
                .padding(.top, 50)
            
            DefaultTextField(label: "Password", titleKey: "password", secured: true, onChange: {}, text: $password)
                .padding(.top, 20)

            
            Spacer()
            Text("테스트")
        })
        .padding(EdgeInsets(top: 0, leading: 20, bottom: 20, trailing: 30))
        
    }
}

#Preview {
    LoginScreen()
}
