import { Component } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/Rx';

@Component({
    selector: 'authentication__login',
    templateUrl: 'src/app/components/authentication/inner/sign-in/sign-in.component.html',
    styleUrls: [
        'src/app/components/authentication/inner/sign-in/sign-in.component.css',
        'src/app/assets/grid.css'
    ]
})

export class SignInComponent {
    public signIn() {
        
    }
}