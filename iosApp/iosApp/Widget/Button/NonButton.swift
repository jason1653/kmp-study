//
//  NonButton.swift
//  iosApp
//
//  Created by jason on 4/22/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct NonButton: View {
    let title: String
    let action: () -> ()
    var body: some View {
        Button(action: action) {
            Text(title)
                .frame(maxWidth: .infinity)
                .foregroundColor(Color.white)
                .padding(.top, 20)
                .transition(.move(edge: .bottom).combined(with: .opacity))

        }
    }
}

#Preview {
    NonButton(title: "로그인", action: {})
}
