//
//  LoginRepoUseCase.swift
//  iosApp
//
//  Created by jason on 4/25/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation


protocol LoginRepoUseCase {
    func loginProc()
    func existsByUserId(userId: String)
}

struct LoginRepoUseCaseImpl: LoginRepoUseCase {
    func loginProc() {
        
    }
    
    func existsByUserId(userId: String) {
        
    }
    
    
}
