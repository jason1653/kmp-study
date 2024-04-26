//
//  PrimaryButton.swift
//  iosApp
//
//  Created by jason on 4/22/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct PrimaryButton: View {
    let title: String
    let action: () -> ()
    var body: some View {
        Button(action: action) {
            Text(title)
                .frame(maxWidth: .infinity)
                .padding()
                .background(Color("primary"))
                .cornerRadius(3.0)
                .foregroundColor(Color.white)
                .transition(.move(edge: .bottom).combined(with: .opacity))

        }
    }
}

#Preview {
    PrimaryButton(title: "버튼", action: {})
}
