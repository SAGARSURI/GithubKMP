//
//  BaseView.swift
//  GithubKMP
//
//  Created by Sagar Suri on 07/04/19.
//  Copyright © 2019 Sagar Suri. All rights reserved.
//

import Foundation
import shared
import UIKit

extension UIViewController: BaseView{
    
    public func showError(error: KotlinThrowable) {
        let title: String = "Error"
        var errorMessage: String? = nil
        switch error{
        case is UpdateProblem:
            errorMessage = "Unable to retrieve data from github"
        default:
            errorMessage = "Unknown error"
        }
        
        if let message = errorMessage{
            self.showError(title: title
                , message: message)
        }
    }
    
    func showError(title: String, message: String){
        let alertController = UIAlertController(title: title
            , message: message
            , preferredStyle: UIAlertController.Style.alert)
        alertController.addAction(UIAlertAction(title: "Dismiss"
            , style: UIAlertAction.Style.default, handler: nil))
        self.present(alertController,animated: true, completion: nil)
    }
}
