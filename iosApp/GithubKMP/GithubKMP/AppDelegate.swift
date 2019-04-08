//
//  AppDelegate.swift
//  GithubKMP
//
//  Created by Sagar Suri on 06/04/19.
//  Copyright © 2019 Sagar Suri. All rights reserved.
//

import UIKit
import shared

@UIApplicationMain
class AppDelegate: UIResponder, UIApplicationDelegate {
    
    public lazy var dataRepository = { MemberDataRepository(api: GithubApi()) }()

    var window: UIWindow?
    
    static var appDelegate: AppDelegate{
        return UIApplication.shared.delegate as! AppDelegate
    }

}

