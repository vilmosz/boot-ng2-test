import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';
import 'rxjs/Rx';
import { Configuration } from '../app.constants';

export class User {        
    id: string;
    firstName: string;
    lastName: string;
    url: string;
    email: string;

    constructor(user: any) {
        if (user) {
            this.id = user.id;
            this.firstName = user.firstName;
            this.lastName = user.lastName;
            this.url = user.url;
            this.email = user.email;
        }
    }
}

@Injectable()
export class UserService {
 
    private headers = new Headers({'Content-Type': 'application/json'});
    private apiCall:string;
    
    constructor(private http: Http, private configuration: Configuration) {
        this.apiCall = configuration.ActivitiApi + 'identity/users';
        //this.apiCall = 'http://localhost:8080/identity/users';
        console.log(this.apiCall);
    }
    
    getUsers(): Promise<User[]> {
        return Promise.resolve(
                this.http
                    .get(this.apiCall)
                    .map((res:Response) => <User[]>res.json().data)
        );
    }
        
}