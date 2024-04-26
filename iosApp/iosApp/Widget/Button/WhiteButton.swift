//
//  WhiteButton.swift
//  iosApp
//
//  Created by jason on 4/26/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct WhiteButton: View {
    let title: String
    let action: () -> ()
    var body: some View {
        Button(action: action) {
            Text(title)
                .frame(maxWidth: .infinity)
                .padding()
                .background(Color.white)
                .cornerRadius(3.0)
                .foregroundColor(Color.black)
                .transition(.move(edge: .bottom).combined(with: .opacity))

        }
    }
}

#Preview {
    WhiteButton(title: "테스트", action: {})
}
