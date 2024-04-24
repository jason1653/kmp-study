//
//  ErrorHandler.swift
//  iosApp
//
//  Created by jason on 4/24/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation


class ErrorHandler {
    static func handle<T>(_ asyncOperation: @escaping () async throws -> T, completion: @escaping (T?, Error?) -> Void) {
        Task {
            do {
                let result = try await asyncOperation()
                completion(result, nil)
            } catch {
                completion(nil, error)
            }
        }
    }
}
