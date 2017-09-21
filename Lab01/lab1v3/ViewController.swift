//
//  ViewController.swift
//  lab1v3
//
//  Created by Cassandra Goodby on 9/12/17.
//  Copyright © 2017 Cassandra Goodby. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var topLabel: UILabel!
    
    @IBOutlet weak var backgroundImage: UIImageView!
    
    @IBOutlet weak var mainText: UILabel!
    
    override func willRotate(to toInterfaceOrientation: UIInterfaceOrientation, duration: TimeInterval) {
        if(UIDevice.current.orientation == UIDeviceOrientation.landscapeLeft || UIDevice.current.orientation == UIDeviceOrientation.landscapeRight){
            backgroundImage.image=UIImage(named: "background")
            mainText.text=""
        }
        else{
            backgroundImage.image=UIImage(named: "background")
            mainText.text=""
        }
        }
    

    @IBAction func changeBG(_ sender: UIButton) {
        if(sender.tag == 1 && UIDevice.current.orientation == UIDeviceOrientation.landscapeLeft){
            backgroundImage.image=UIImage(named: "backgroundmorningside")
            
            mainText.text="Good Morning"
        }
        
        else if(sender.tag == 1 && UIDevice.current.orientation == UIDeviceOrientation.landscapeRight){
            backgroundImage.image=UIImage(named: "backgroundmorningside")
            
            mainText.text="Good Morning"
        }
        
        else if(sender.tag == 1 && UIDevice.current.orientation == UIDeviceOrientation.portrait){
            backgroundImage.image=UIImage(named: "backgroundmorning")
            
            mainText.text="Good Morning"
        }
        
        else if(sender.tag==2 && UIDevice.current.orientation == UIDeviceOrientation.landscapeLeft){
            backgroundImage.image=UIImage(named: "backgrounddayside")
            
            mainText.text="It's a beautiful day"
            
        }
            
        else if(sender.tag == 2 && UIDevice.current.orientation == UIDeviceOrientation.landscapeRight){
            backgroundImage.image=UIImage(named: "backgrounddayside")
            
            mainText.text="It's a beautiful day"
        }
            
        else if(sender.tag == 2 && UIDevice.current.orientation == UIDeviceOrientation.portrait){
            backgroundImage.image=UIImage(named: "backgroundday")
            
            mainText.text="It's a beautiful day"
        }

        
        else if(sender.tag==3 && UIDevice.current.orientation == UIDeviceOrientation.landscapeLeft ){
            backgroundImage.image=UIImage(named: "backgroundnightside")
            
            mainText.text="Sweet Dreams"
            
        }
            
        else if(sender.tag == 3 && UIDevice.current.orientation == UIDeviceOrientation.landscapeRight){
            backgroundImage.image=UIImage(named: "backgroundnightside")
            
            mainText.text="Sweet Dreams"
        }
            
        else if(sender.tag == 3 && UIDevice.current.orientation == UIDeviceOrientation.portrait){
            backgroundImage.image=UIImage(named: "backgroundnight")
            
            mainText.text="Sweet Dreams"
        }

    }
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

