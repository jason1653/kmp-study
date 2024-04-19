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
                .frame(maxWidth: .infinity, alignment: .leading)
            textField
                .autocapitalization(.none)
                .padding()
                .onChange(of: text) { _ in
                    onChange()
                }
                .overlay {
                    RoundedRectangle(cornerRadius: 5)
                        .stroke(isFocused ? Color.blue : Color("gray"), lineWidth: isFocused ? 2 : 1)
                }
        }
        .frame(alignment: .leading)
    }
}

struct DefaultTextField_Previews: PreviewProvider {
    @State static var userId: String = ""
    
    static var previews: some View {
        DefaultTextField(label: "Email", titleKey: "Username", secured: false, onChange: {}, text: $userId)
    }
}
