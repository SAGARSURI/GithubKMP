//
//  MemberList.swift
//  GithubKMP
//
//  Created by Sagar Suri on 07/04/19.
//  Copyright © 2019 Sagar Suri. All rights reserved.
//

import Foundation
import shared

class MemberList {
    var members: [Member] = []
    func updateMembers(_ newMembers: [Member]) {
        members.removeAll()
        members.append(contentsOf: newMembers)
    }
}
