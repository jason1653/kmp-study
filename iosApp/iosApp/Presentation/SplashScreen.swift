//
//  SplashScreen.swift
//  iosApp
//
//  Created by jason on 4/19/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct SplashScreen: View {
    @State var splashLoading = false
    @State var logoPaddingBottom: CGFloat = 0
    @State private var isShowLoginScreen = false
    @State private var isShowRegistScreen = false
    var body: some View {
        ZStack {
            VStack {
                Spacer()
                Text("coinbase")
                    .padding(.bottom, logoPaddingBottom)
                    .foregroundColor(Color.white)
                    .font(.system(size: 28))
                    .fontWeight(.bold)
                
                    
                Spacer()
            }
            VStack {
                Spacer()
                
                if splashLoading {
                    
                    WhiteButton(title: "회원가입", action: {
                        isShowRegistScreen = true
                    }).fullScreenCover(isPresented: $isShowRegistScreen, content: {
                        RegistScreen(isShowRegistScreen: $isShowRegistScreen)
                    })
                       
                    
                    NonButton(title: "로그인", action: {
                        isShowLoginScreen = true
                    }).fullScreenCover(isPresented: $isShowLoginScreen, content: {
                        LoginScreen(isShowLoginScreen: $isShowLoginScreen)
                    })
                    Divider()
                        .overlay(Color.white)
                        .padding(EdgeInsets(top: 20, leading: 0, bottom: 20, trailing: 0))
                    
                    HStack {
                        Button(action: {}) {
                            Image("NaverBtnIcon")
                                .resizable()
                                .scaledToFit()
                                .frame(width: 50, height: 50)
                        }
                        Button("카카오", action: {})
                        Button("애플", action: {})
                        
                    }
                    
                }

            }
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity)
        .padding()
        .background(Color("primary"))
        .onAppear {
            DispatchQueue.main.asyncAfter(deadline: .now() + 2, execute: {
                withAnimation(.easeInOut(duration: 0.5)) {
                    splashLoading = true
                    logoPaddingBottom = 200
                }
            })
        }
        
    }
}

#Preview {
    SplashScreen()
}
