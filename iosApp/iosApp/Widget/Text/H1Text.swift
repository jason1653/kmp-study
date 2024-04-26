//
//  H1Text.swift
//  iosApp
//
//  Created by jason on 4/26/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct H1Text: View {
    let text: String
    var body: some View {
        Text(text)
            .fontWeight(.bold)
            .font(.system(size: 24))
            .padding(.top, 30)
    }
}

#Preview {
    H1Text(text: "test")
}
