//
//  DefaultTextField.swift
//  iosApp
//
//  Created by jason on 4/19/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct DefaultTextField: View {
    let label: String
    let titleKey: String
    let secured: Bool
    @Binding var errorMessage: String
    let onChange: () -> ()
    
    @Binding var text: String
    @FocusState private var isFocused: Bool
    
    @ViewBuilder var textField: some View {
        if secured {
            SecureField(titleKey, text: $text)
                .frame(maxWidth: .infinity, alignment: .leading)
        } else {
            TextField(titleKey, text: $text)
                .frame(maxWidth: .infinity, alignment: .leading)
        }
    }
    
    var body: some View {
        VStack {
            
            Text(label)
                .fontWeight(.bold)
                .font(.system(size: 16))
                .frame(maxWidth: .infinity, alignment: .leading)
                .foregroundColor(!errorMessage.isEmpty ? .red : .primary)
                
            
            textField
                .autocapitalization(.none)
                .padding()
                .onChange(of: text) { _ in
                    onChange()
                }
                .overlay {
                    RoundedRectangle(cornerRadius: 5)
                        .stroke(!errorMessage.isEmpty ? Color.red : Color("gray"), lineWidth: !errorMessage.isEmpty ? 2 : 1)
                }
            if !errorMessage.isEmpty {
                Text(errorMessage ?? "")
                    .fontWeight(.bold)
                    .font(.system(size: 12))
                    .frame(maxWidth: .infinity, alignment: .leading)
                    .padding(.leading, 10)
                    .padding(.top, 2)
                    .foregroundColor(.red)
            }
        }
        .frame(alignment: .leading)
    }
}

struct DefaultTextField_Previews: PreviewProvider {
    @State static var userId: String = ""
    @State static var errorMessage: String = ""
    
    static var previews: some View {
        DefaultTextField(label: "Email", titleKey: "Username", secured: false, errorMessage: $errorMessage, onChange: {}, text: $userId)
    }
}
