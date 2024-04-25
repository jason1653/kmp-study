//
//  ErrorResponseException.swift
//  iosApp
//
//  Created by jason on 4/25/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation

struct APIErrorResponse: Codable, Error {
    let code: String
    let message: String
    let status: Int
    let body: String
}

extension APIErrorResponse {
    init?(data: Data) {
        guard let me = try? JSONDecoder().decode(APIErrorResponse.self, from: data) else {
            return nil
        }
        self = me
    }
}
