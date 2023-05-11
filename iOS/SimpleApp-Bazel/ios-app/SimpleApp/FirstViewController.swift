//
//  Copyright © 2022 Product Science. All rights reserved.
//

import UIKit

final class FirstViewController: UIViewController {

    @IBAction func didTapWithDelay(_ sender: UIButton) {
        sender.isEnabled = false
        DispatchQueue.main.asyncAfter(deadline: .now() + 1) {
            let vc = SecondViewController()
            self.navigationController?.pushViewController(vc, animated: true)
            sender.isEnabled = true
        }
    }

    @IBAction func didTapWithoutDelay(_ sender: UIButton) {
        sender.isEnabled = false
        let vc = SecondViewController()
        navigationController?.pushViewController(vc, animated: true)
        sender.isEnabled = true
    }
}

