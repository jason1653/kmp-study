//
//  TopNavigation.swift
//  iosApp
//
//  Created by jason on 4/26/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct TopNavigation: View {
    let action: () -> ()
    enum SystemIcon: String {
        case close = "xmark"
        case back = "arrow.backward"
    }
    var iconName: SystemIcon
    
    var body: some View {
        HStack {
            Button(action: action) {
                Image(systemName: "xmark")
                    .resizable()
                    .scaledToFit()
                    .frame(width: 15, height: 15)
                    .foregroundColor(.black)
            }
            .padding(.top, 20)
            Spacer()
        }
    }
}

#Preview {
    VStack {
        TopNavigation(action: {}, iconName: .back)
        TopNavigation(action: {}, iconName: .close)

    }

}
