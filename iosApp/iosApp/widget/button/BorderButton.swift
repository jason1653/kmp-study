//
//  BorderButton.swift
//  iosApp
//
//  Created by jason on 4/22/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct BorderButton: View {
    let title: String
    let action: () -> ()
    var body: some View {
        Button(action: action) {
            Text(title)
                .frame(maxWidth: .infinity)
                .padding()
                .background(Color.white)
                .border(Color("gray"))
                .cornerRadius(3.0)
                .foregroundColor(Color.black)
                .transition(.move(edge: .bottom).combined(with: .opacity))

        }
    }
}

#Preview {
    BorderButton(title: "버튼", action: {})
}
