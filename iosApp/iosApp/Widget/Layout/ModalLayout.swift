//
//  ModalLayout.swift
//  iosApp
//
//  Created by jason on 4/26/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct ModalLayout<Content: View>: View {
    let content: Content
    init(@ViewBuilder contents: () -> Content) {
        self.content = contents()
    }
    

    var body: some View {
        ZStack {
            VStack(alignment: .leading) {
                content
            }.padding(EdgeInsets(top: 0, leading: 20, bottom: 20, trailing: 20))
        }
    }
}

#Preview {
    ModalLayout {
        Text("1111")
    }
}
