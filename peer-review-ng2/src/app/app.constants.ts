import { Injectable } from '@angular/core';
 
@Injectable()
export class Configuration {
    public Server: string = "http://localhost:8080";
    public CustomEndpoint: string = "/api";
    public ActivitiEndpoint: string = "/";
    public CustomApi: string = this.Server + this.CustomEndpoint;
    public ActivitiApi: string = this.Server + this.ActivitiEndpoint;
}