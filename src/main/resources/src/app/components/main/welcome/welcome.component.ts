import 'rxjs/Rx';
import { Http } from '@angular/http';
import { Component } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';

@Component({
    selector: 'welcome-page',
    templateUrl: 'src/app/components/main/welcome/welcome.component.html',
    styleUrls: [
        'src/app/assets/grid.css',
        'src/app/assets/panel.css'
    ]
})

export class WelcomeComponent {
}