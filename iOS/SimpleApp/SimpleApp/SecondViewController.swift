//
//  Copyright © 2022 Product Science. All rights reserved.
//

import UIKit

final class SecondViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()

        view.backgroundColor = .systemBackground

        let label = UILabel()
        label.font = .preferredFont(forTextStyle: .largeTitle, compatibleWith: .current)
        label.text = "2"
        view.addSubview(label)
        label.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            label.centerXAnchor.constraint(equalTo: view.centerXAnchor),
            label.centerYAnchor.constraint(equalTo: view.centerYAnchor)
        ])
    }
}
