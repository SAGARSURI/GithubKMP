//
//  ViewController.swift
//  GithubKMP
//
//  Created by Sagar Suri on 06/04/19.
//  Copyright © 2019 Sagar Suri. All rights reserved.
//

import UIKit
import shared

class ViewController: UIViewController, MembersView {
    
    let memberList = MemberList()

    lazy var presenter: MembersPresenter = {
        MembersPresenter(view: self, repository: AppDelegate.appDelegate.dataRepository)
    }()
    var isUpdating = false
    
    @IBOutlet weak var greeting: UILabel!
    @IBOutlet weak var membersTableView: UITableView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        greeting.text = Greetings().greeting()
        membersTableView.register(UINib(nibName: "MemberCellTableViewCell", bundle: nil), forCellReuseIdentifier: "MemberCell")
    }
    
    override func viewWillAppear(_ animated: Bool) {
        presenter.onCreate()
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        presenter.onDestroy()
    }

    func onUpdate(members: [Member]) {
        self.memberList.updateMembers(members)
        self.membersTableView.reloadData()
    }

}

extension ViewController: UITableViewDataSource {
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return self.memberList.members.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "MemberCell", for: indexPath) as! MemberCellTableViewCell
        let member = self.memberList.members[indexPath.row]
        cell.memberLogin.text = member.login
        cell.memberAvatar.load(url: URL(string: member.avatarUrl)!)
        return cell
    }
}

extension UIImageView {
    func load(url: URL) {
        DispatchQueue.global().async { [weak self] in
            if let data = try? Data(contentsOf: url) {
                if let image = UIImage(data: data) {
                    DispatchQueue.main.async {
                        self?.image = image
                    }
                }
            }
        }
    }
}

