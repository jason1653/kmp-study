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
                print("catch 오류 처리")
                
                if let jsonErrorString = extractJSONText(from: error.localizedDescription),
                   let apiError = parseJSONError(from: jsonErrorString) {
                    print("API Error: \(apiError.message)")
                    completion(nil, apiError)  // Pass nil for result and apiError for Error
                } else {
                    // If the JSON parsing fails or no JSON string is found
                    print("Failed to parse JSON error message or no JSON string found: \(error.localizedDescription)")
                    completion(nil, error)  // Pass nil for result and the original error
                }
                
            }
        }
    }
    
    private static func extractJSONText(from text: String) -> String? {
       let pattern = #"\. Text: "(.*?)"$"#  // Regular expression to find the JSON string
       if let regex = try? NSRegularExpression(pattern: pattern, options: []),
          let match = regex.firstMatch(in: text, options: [], range: NSRange(text.startIndex..., in: text)),
          let range = Range(match.range(at: 1), in: text) {
           return String(text[range])
       }
       return nil
   }

    private static func parseJSONError(from jsonString: String) -> APIErrorResponse? {
        guard let data = jsonString.data(using: .utf8) else { return nil }
        return try? JSONDecoder().decode(APIErrorResponse.self, from: data)
    }
}
