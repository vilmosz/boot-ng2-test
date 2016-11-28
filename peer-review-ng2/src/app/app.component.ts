import { Component, OnInit } from '@angular/core';
import { UserService, User } from './service/identity.service'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [UserService]
})

export class AppComponent implements OnInit  {
    
    error: string;
    users: User[];
        
    constructor(private service: UserService){
        this.service = service;
    }

    ngOnInit(): void {
        this.getUsers();
    }
        
    private getUsers(): void {
        this.service.getUsers().then(users => this.users = users);
    }
        
}
